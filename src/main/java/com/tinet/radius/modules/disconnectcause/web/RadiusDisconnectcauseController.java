package com.tinet.radius.modules.disconnectcause.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tinet.radius.common.config.Global;
import com.tinet.radius.common.persistence.Page;
import com.tinet.radius.common.web.BaseController;
import com.tinet.radius.common.utils.StringUtils;
import com.tinet.radius.modules.disconnectcause.entity.RadiusDisconnectcause;
import com.tinet.radius.modules.disconnectcause.service.RadiusDisconnectcauseService;

/**
 * 故障对照表类描述Controller
 * @author 王贵宇
 * @version 2016-06-28
 */
@Controller
@RequestMapping(value = "${adminPath}/disconnectcause/radiusDisconnectcause")
public class RadiusDisconnectcauseController extends BaseController {

	@Autowired
	private RadiusDisconnectcauseService radiusDisconnectcauseService;
	
	@ModelAttribute
	public RadiusDisconnectcause get(@RequestParam(required=false) String id) {
		RadiusDisconnectcause entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = radiusDisconnectcauseService.get(id);
		}
		if (entity == null){
			entity = new RadiusDisconnectcause();
		}
		return entity;
	}
	
	@RequiresPermissions("disconnectcause:radiusDisconnectcause:view")
	@RequestMapping(value = {"list", ""})
	public String list(RadiusDisconnectcause radiusDisconnectcause, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RadiusDisconnectcause> page = radiusDisconnectcauseService.findPage(new Page<RadiusDisconnectcause>(request, response), radiusDisconnectcause); 
		model.addAttribute("page", page);
		return "modules/disconnectcause/radiusDisconnectcauseList";
	}

	@RequiresPermissions("disconnectcause:radiusDisconnectcause:view")
	@RequestMapping(value = "form")
	public String form(RadiusDisconnectcause radiusDisconnectcause, Model model) {
		model.addAttribute("radiusDisconnectcause", radiusDisconnectcause);
		return "modules/disconnectcause/radiusDisconnectcauseForm";
	}

	@RequiresPermissions("disconnectcause:radiusDisconnectcause:edit")
	@RequestMapping(value = "save")
	public String save(RadiusDisconnectcause radiusDisconnectcause, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, radiusDisconnectcause)){
			return form(radiusDisconnectcause, model);
		}
		radiusDisconnectcauseService.save(radiusDisconnectcause);
		addMessage(redirectAttributes, "保存故障原因成功");
		return "redirect:"+Global.getAdminPath()+"/disconnectcause/radiusDisconnectcause/?repage";
	}
	
	@RequiresPermissions("disconnectcause:radiusDisconnectcause:edit")
	@RequestMapping(value = "delete")
	public String delete(RadiusDisconnectcause radiusDisconnectcause, RedirectAttributes redirectAttributes) {
		radiusDisconnectcauseService.delete(radiusDisconnectcause);
		addMessage(redirectAttributes, "删除故障原因成功");
		return "redirect:"+Global.getAdminPath()+"/disconnectcause/radiusDisconnectcause/?repage";
	}

}