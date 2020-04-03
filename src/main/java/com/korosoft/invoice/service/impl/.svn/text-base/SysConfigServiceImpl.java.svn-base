package com.korosoft.invoice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korosoft.invoice.bean.SysConfigBean;
import com.korosoft.invoice.repository.SysConfigRepository;
import com.korosoft.invoice.service.Contans;
import com.korosoft.invoice.service.SysConfigService;

@Service
@Transactional
public class SysConfigServiceImpl implements SysConfigService{
	
	private SysConfigRepository sysConfigRepository;
	
	@Autowired
	public SysConfigServiceImpl(SysConfigRepository sysConfigRepository) {
		this.sysConfigRepository = sysConfigRepository;
	}

	@Override
	@Cacheable(value = Contans.CACHE_NAME, key = "'config_'+#id")
	public SysConfigBean getSysConfigById(long id) {
		return sysConfigRepository.getOne(id);
	}

	@Override
	@CacheEvict(value = Contans.CACHE_NAME, allEntries = true)
	public void save(SysConfigBean bean) {
		if(StringUtils.isBlank(bean.getInvoiceAuto())) {
			bean.setInvoiceAuto("0");
		}
		if(StringUtils.isBlank(bean.getIsTax())) {
			bean.setInvoiceAuto("1");
		}
		sysConfigRepository.save(bean);
	}

	@Override
	public Page<SysConfigBean> listSysConfigPage(SysConfigBean bean, int page, int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize, new Sort(Sort.Direction.ASC, "id") );
		Specification<SysConfigBean> spec = new Specification<SysConfigBean>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<SysConfigBean> root, CriteriaQuery<?> query,CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(bean.getBusSysName())){
                    predicates.add(criteriaBuilder.like(root.get("busSysName"), "%" + bean.getBusSysName() + "%"));
                }
                if(StringUtils.isNotBlank(bean.getGroupName())){
                    predicates.add(criteriaBuilder.like(root.get("groupName"), bean.getGroupName()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                query.where(predicates.toArray(pre));
                return criteriaBuilder.and(predicates.toArray(pre));
			}
		};
		return sysConfigRepository.findAll(spec, pageable);
	}

	@Override
	@CacheEvict(value = Contans.CACHE_NAME, allEntries = true)
	public void deleteById(long id) {
		sysConfigRepository.deleteById(id);
	}

	@Override
	@Cacheable(value = Contans.CACHE_NAME, key = "'config_'+#groupCode")
	public SysConfigBean getSysConfigByGroupCode(int groupCode) {
		return sysConfigRepository.findByGroupCode(groupCode);
	}

	@Override
	public List<SysConfigBean> listAllSysConfig() {
		return sysConfigRepository.findAll();
	}
}
