package com.korosoft.invoice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korosoft.invoice.bean.SysConfigBean;
import com.korosoft.invoice.bean.SysLogBean;
import com.korosoft.invoice.repository.SysLogRepository;
import com.korosoft.invoice.service.SysConfigService;
import com.korosoft.invoice.service.SysLogService;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService{
	
	private SysLogRepository sysLogRepository;
	
	private SysConfigService sysConfigService;
	
	@Autowired
	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	@Autowired
	public SysLogServiceImpl(SysLogRepository sysLogRepository) {
		this.sysLogRepository = sysLogRepository;
	}

	@Override
	public void save(SysLogBean bean) {
		if(bean.getGroupCode() != null) {
			SysConfigBean config = sysConfigService.getSysConfigByGroupCode(bean.getGroupCode());//根据公司ID查询配置信息
			bean.setGroupName(config.getGroupName());
		}
		if("/invoice/api/electronic".equals(bean.getRequestUri())&&bean.getRequestData().indexOf("oldBillBatch") ==-1){
			bean.setRequestName("电子发票开具");
		}else if("/invoice/api/electronic".equals(bean.getRequestUri())&&bean.getRequestData().indexOf("oldBillBatch") !=-1){
			bean.setRequestName("电子发票红冲");
		}else if("/invoice/api/special/open".equals(bean.getRequestUri())&&bean.getRequestData().indexOf("invType") ==-1){
			bean.setRequestName("专票开具");
		}else if("/invoice/api/special/open".equals(bean.getRequestUri())&&bean.getRequestData().indexOf("invType") !=-1){
			bean.setRequestName("专票作废");
		}else if("/invoice/api/special/cancel".equals(bean.getRequestUri())){
			bean.setRequestName("专票撤回");
		}else if("/invoice/api/special/queryDetailed".equals(bean.getRequestUri())){
			bean.setRequestName("发票明细查询");
		}else if("/invoice/api/special/queryStock".equals(bean.getRequestUri())){
			bean.setRequestName("库存查询");
		}else{
			bean.setRequestName("其他");
		}
		sysLogRepository.save(bean);
	}

	@Override
	public Page<SysLogBean> listSysLogPage(SysLogBean bean, int page, int pageSize) {
		
		Pageable pageable = PageRequest.of(page, pageSize, Direction.DESC, "endDate");
		Specification<SysLogBean> querySpecifi = new Specification<SysLogBean>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<SysLogBean> root, CriteriaQuery<?> query,CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
                if(null != bean.getBeginDate()){
                    predicates.add(criteriaBuilder.greaterThan(root.get("beginDate"), bean.getBeginDate()));
                }
                if(null != bean.getEndDate()){
                    predicates.add(criteriaBuilder.lessThan(root.get("endDate"), bean.getEndDate()));
                }
                if(StringUtils.isNotEmpty(bean.getRequestName())){
                    predicates.add(criteriaBuilder.equal(root.get("requestName"), bean.getRequestName()));
                }
                if(StringUtils.isNotEmpty(bean.getType())) {
                	predicates.add(criteriaBuilder.equal(root.get("type"), bean.getType()));
                }
                predicates.add(criteriaBuilder.and(criteriaBuilder.isNotNull(root.get("groupName"))));
                Predicate[] pre = new Predicate[predicates.size()];
                query.where(predicates.toArray(pre));
                return criteriaBuilder.and(predicates.toArray(pre));
			}
		};
		return sysLogRepository.findAll(querySpecifi, pageable);
	}
}
