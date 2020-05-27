package edu.zut.cs.software.base.web.spring.controller;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.base.domain.BaseEntity;
import edu.zut.cs.software.base.service.GenericManager;

/**
 * 
 * @author shishuqian
 * 
 */
public abstract class GenericController<T extends BaseEntity<PK>, PK extends Serializable, M extends GenericManager<T, PK>>
		extends BaseController {
	protected PK id;
	protected M manager;
	protected T model;
	protected Page<T> page;

	protected Pageable pageable;
	protected int pageNumber = 0;
	protected int pageSize = 20;

	/**
	 * @param model entity model
	 * @return new created entity
	 */
	@PostMapping(value = "/", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public T create(@RequestBody T model) {
		this.model = model;
		Date date = new Date();
		this.model.setDateCreated(date);
		this.model.setDateModified(date);
		this.model = this.manager.save(this.model);
		return this.model;
	}

	/**
	 * @param id entity id
	 */
	@DeleteMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public void delete(@PathVariable PK id) {
		this.manager.delete(id);
	}

	/**
	 * @param id entity id
	 * @return found entity
	 */
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public T findById(@PathVariable PK id) {
		return this.manager.findById(id);

	}

	/**
	 * 根据输入，返回分页结果中的当前页，包括当前页信息和其中的实体对象集合
	 * 
	 * @param pageNumber number order of current page
	 * @param pageSize   size of current page
	 * @return pagable entity list
	 */
	@GetMapping(value = "/", produces = "application/json")
	@ResponseBody
	public Page<T> get(@RequestParam(name = "page", defaultValue = "0") String pageNumber,
			@RequestParam(name = "limit", defaultValue = "20") String pageSize) {
		if (StringUtils.isNotBlank(pageNumber)) {
			this.pageNumber = Integer.valueOf(pageNumber) - 1;
		}
		if (StringUtils.isNotBlank(pageSize)) {
			this.pageSize = Integer.valueOf(pageSize);
		}
		this.pageable = PageRequest.of(this.pageNumber, this.pageSize, Sort.by(Direction.ASC, "id"));
		this.page = this.manager.findAll(this.pageable);
		logger.info(this.page);
		return this.page;
	}

	/**
	 * @param id    entity code to update
	 * @param model entity information to update
	 * @return updated entity
	 */
	@PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public T update(@PathVariable PK id, @RequestBody T model) {
		model.setId(id);
		model.setDateModified(new Date());// 更新修改时间
		this.model = this.manager.save(model);
		return this.model;
	}

}
