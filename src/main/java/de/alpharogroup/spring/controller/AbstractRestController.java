package de.alpharogroup.spring.controller;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.copy.object.CopyObjectExtensions;
import de.alpharogroup.mapstruct.mapper.GenericMapper;
import de.alpharogroup.spring.service.api.GenericService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AbstractRestController<T, ID, R extends JpaRepository<T, ID>, D>
{

	GenericService<T, ID, R> service;

	GenericMapper<T, D> mapper;

	@RequestMapping
	public @ResponseBody Iterable<T> listAll()
	{
		return this.service.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<D> save(@RequestBody D json)
	{
		T created = this.service.save(mapper.toEntity(json));
		return ResponseEntity.ok(mapper.toDto(created));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<D> get(@PathVariable ID id)
	{
		return ResponseEntity.ok(mapper.toDto(this.service.getOne(id)));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<D> update(@PathVariable ID id, @RequestBody D json)
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

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> delete(@PathVariable ID id)
	{
		this.service.deleteById(id);
		Map<String, Object> map = MapFactory.newHashMap();
		map.put("success", true);
		return map;
	}

}

