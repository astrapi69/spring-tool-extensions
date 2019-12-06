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
package de.alpharogroup.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.alpharogroup.bean.mapper.GenericMapper;
import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.copy.object.CopyObjectExtensions;
import de.alpharogroup.spring.service.api.GenericService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AbstractRestController<T, ID, R extends JpaRepository<T, ID>, D>
{

	GenericMapper<T, D> mapper;

	GenericService<T, ID, R> service;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the entity from the given id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "the id from the entity to delete", paramType = "query") })
	public Map<String, Object> delete(@PathVariable ID id)
	{
		Optional<T> optionalEntity = this.service.findById(id);
		Map<String, Object> map = MapFactory.newHashMap();
		if (optionalEntity.isPresent())
		{
			D dto = mapper.toDto(optionalEntity.get());
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

	@RequestMapping
	@ApiOperation(value = "Find all entities")
	public Iterable<T> findAll()
	{
		return this.service.findAll();
	}

	@ApiOperation(value = "Get the entity from the given id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "the id from the entity to get", paramType = "query") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<D> get(@PathVariable ID id)
	{
		return ResponseEntity.ok(mapper.toDto(this.service.getOne(id)));
	}

	@ApiOperation(value = "Saves the given json object")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "json", value = "the json object to save", paramType = "body") })
	@RequestMapping(method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<D> save(@Valid @RequestBody D viewModel)
	{
		T created = this.service.save(mapper.toEntity(viewModel));
		D dto = mapper.toDto(created);
		return ResponseEntity.ok(dto);
	}

	@ApiOperation(value = "Update the entity from the given id with the given new json object")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "the id from the entity to get", paramType = "query"),
			@ApiImplicitParam(name = "json", value = "the json object to save", paramType = "body") })
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<D> update(@PathVariable ID id, @RequestBody D json)
	{
		T entity = this.service.getOne(id);
		T toUpdate = mapper.toEntity(json);
		try
		{
			CopyObjectExtensions.copy(toUpdate, entity);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}

		T updated = this.service.save(entity);

		return ResponseEntity.ok(mapper.toDto(updated));
	}

}

