/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.spring.controller;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import io.github.astrapi69.entity.identifiable.Identifiable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.astrapi69.bean.mapper.GenericModelMapper;
import io.github.astrapi69.collections.map.MapFactory;
import io.github.astrapi69.copy.object.CopyObjectExtensions;
import io.github.astrapi69.spring.service.api.GenericService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AbstractRestController<ENTITY extends Identifiable<ID>, ID extends Serializable, REPOSITORY extends JpaRepository<ENTITY, ID>, DTO>
{

	GenericModelMapper<ENTITY, DTO> mapper;

	GenericService<ENTITY, ID, REPOSITORY> service;

	@ApiOperation(value = "Delete the given json object")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "json", value = "the json object to delete", paramType = "body") })
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<DTO> delete(@Valid @RequestBody DTO viewModel)
	{
		ENTITY entity = mapper.toEntity(viewModel);
		this.service.delete(entity);
		return ResponseEntity.ok(viewModel);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the entity from the given id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "the id from the entity to delete", paramType = "query") })
	public Map<String, Object> deleteById(@PathVariable ID id)
	{
		Optional<ENTITY> optionalEntity = this.service.findById(id);
		Map<String, Object> map = MapFactory.newHashMap();
		if (optionalEntity.isPresent())
		{
			DTO dto = mapper.toDto(optionalEntity.get());
			map.put("deleted-object", dto);
			this.service.deleteById(id);
		}
		else
		{
			map.put("deleted-object", "not exists");
		}
		map.put("success", true);
		return map;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Find all entities")
	public Iterable<ENTITY> findAll()
	{
		return this.service.findAll();
	}

	@ApiOperation(value = "Get the entity from the given id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "the id from the entity to get", paramType = "query") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DTO> get(@PathVariable ID id)
	{
		return Optional.ofNullable(this.service.getById(id))
			.map(obj -> new ResponseEntity<>(mapper.toDto(obj), HttpStatus.OK))
			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@ApiOperation(value = "Saves the given json object")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "json", value = "the json object to save", paramType = "body") })
	@RequestMapping(method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<DTO> save(@Valid @RequestBody DTO viewModel)
	{
		ENTITY entity = mapper.toEntity(viewModel);
		ENTITY created = this.service.save(entity);
		DTO dto = mapper.toDto(created);
		return ResponseEntity.ok(dto);
	}

	@ApiOperation(value = "Update the entity from the given id with the given new json object")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "the id from the entity to get", paramType = "query"),
			@ApiImplicitParam(name = "json", value = "the json object to save", paramType = "body") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DTO> update(@PathVariable ID id, @Valid @RequestBody DTO json)
	{
		return Optional.ofNullable(this.service.getById(id)).map(entity -> {
			ENTITY toUpdate = mapper.toEntity(json);
			try
			{
				CopyObjectExtensions.copy(toUpdate, entity);
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}

			ENTITY updatedEntity = this.service.save(entity);

			return new ResponseEntity<>(mapper.toDto(updatedEntity), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
