package com.korosoft.invoice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korosoft.invoice.bean.SysConfigBean;
import com.korosoft.invoice.dto.InvoiceStatisticsDto;
import com.korosoft.invoice.service.InvoiceStatisticsService;
import com.korosoft.invoice.service.SysConfigService;
import com.korosoft.invoice.controller.WebMvcConfig;

@Service
@Transactional(readOnly = true)
public class InvoiceStatisticsServiceImpl implements InvoiceStatisticsService{
	
	private JdbcTemplate jdbcTemplate;
	
	private SysConfigService sysConfigService;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	@Override
	public List<InvoiceStatisticsDto> statistics() {
		List<SysConfigBean> sysConfigs = sysConfigService.listAllSysConfig();
		List<InvoiceStatisticsDto> data = new ArrayList<>();
		for(SysConfigBean sysConfig : sysConfigs) {
			if(sysConfig.getGroupCode()!=1){
			InvoiceStatisticsDto invoiceStatistics = new InvoiceStatisticsDto();
			String str[]=maxInvoiceNum(sysConfig.getGroupCode()).split(","); 
			invoiceStatistics.setGroupName(sysConfig.getGroupName());
			invoiceStatistics.setPreMonthInvoiceNum(preMonthInvoiceNum(sysConfig.getGroupCode()));
			invoiceStatistics.setCurrMonthInvoiceNum(currMonthInvoiceNum(sysConfig.getGroupCode()));
			invoiceStatistics.setMaxInvoiceNum(str[0]+"张("+str[1]+"日"+str[2]+"时)");
			invoiceStatistics.setSuccessInvoiceNum(monthSuccessNum(sysConfig.getGroupCode()));
			invoiceStatistics.setFailInvoiceNum(monthFailNum(sysConfig.getGroupCode()));
			invoiceStatistics.setSuccessRate(successRate(sysConfig.getGroupCode()));
			invoiceStatistics.setAverageTime(averageTime(sysConfig.getGroupCode()));
			invoiceStatistics.setMaxTime(maxTime(sysConfig.getGroupCode()));
			invoiceStatistics.setPreInvoiceRatio(preInvoiceRatio(sysConfig.getGroupCode(),sysConfig.getWatchNum()));
			data.add(invoiceStatistics);
			}
		}
		return data;
	}
	
//	private List queryGroupCode() {
//		return jdbcTemplate.queryForObject("select ", List.class, new Object[] {groupCode});
//	}
	
	private long preMonthInvoiceNum(int groupCode) {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM invoice_log t WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(endtime, '%Y%m' ) ) = 1 and t.REQUESTNAME in ('电子发票开具', '专票开具') AND t.GROUPCODE = ?", Long.class, new Object[] {groupCode});
	}
	
	private long currMonthInvoiceNum(int groupCode) {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM invoice_log t WHERE DATE_FORMAT( endtime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and t.REQUESTNAME in ('电子发票开具', '专票开具') AND t.GROUPCODE = ?", Long.class, new Object[] {groupCode});
	}
	
	private String maxInvoiceNum(int groupCode) {
		try{
			return jdbcTemplate.queryForObject("SELECT CONCAT(count(*), ',',DAY(e.endtime),',',HOUR(e.endtime))  FROM invoice_log e  WHERE DATE_FORMAT( e.ENDTIME, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and e.GROUPCODE=? GROUP BY DAY(e.endtime),HOUR(e.endtime)  ORDER BY count(*) desc limit 1", String.class, new Object[] {groupCode});
		}catch(Exception ex){
			return "0,0,0";
		}
		
	}
	
	private int monthSuccessNum(int groupCode) {
		return jdbcTemplate.queryForObject("select count(*) from invoice_log t where t.type=1 and DATE_FORMAT( t.ENDTIME, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and t.GROUPCODE=?", Integer.class, new Object[] {groupCode});
	}
	
	private int monthFailNum(int groupCode) {
		return jdbcTemplate.queryForObject("select count(*) from invoice_log t where t.type=2 and DATE_FORMAT( t.ENDTIME, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and t.GROUPCODE=?", Integer.class, new Object[] {groupCode});
	}
	
	private double successRate(int groupCode) {
		return jdbcTemplate.queryForObject("select format(if(count(*)>0,sum(case when  t.type = 1  then  1 else 0 end)/count(*),0),2)*100 from invoice_log t where  t.GROUPCODE=?", double.class, new Object[] {groupCode});
	}
	
	private float averageTime(int groupCode) {
		return jdbcTemplate.queryForObject("select format(if(count(*)>0,AVG(UNIX_TIMESTAMP(t.endtime)-UNIX_TIMESTAMP(t.begintime)),0),2) from invoice_log t where t.REQUESTNAME='电子发票开具' and t.GROUPCODE=?", float.class, new Object[] {groupCode});
	}
	
	private float maxTime(int groupCode) {
		return jdbcTemplate.queryForObject("select format(if(count(*)>0,MAX(UNIX_TIMESTAMP(e.ENDTIME)-UNIX_TIMESTAMP(e.BEGINTIME)),0),2) from invoice_log e where DATE_FORMAT( e.ENDTIME, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) AND e.GROUPCODE=?", float.class, new Object[] {groupCode});
	}
	
	private double preInvoiceRatio(int groupCode,int watchNum) {
		return jdbcTemplate.queryForObject("select format(count(*)/?,3) from invoice_log where REQUESTNAME in('电子发票开具','专票开具') and DATE_FORMAT( endtime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )  and GROUPCODE=?", double.class, new Object[] {watchNum,groupCode});
	}
	
	
}
