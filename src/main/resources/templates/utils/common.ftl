<#assign ctx=springMacroRequestContext.getContextPath()>
<#-- 静态资源版本化url处理 -->
<#function static url>
	<#return urls.getForLookupPath(springMacroRequestContext.getContextPath()+url)>
</#function>
<#-- 最大值 -->
<#function max x y>
	<#if x gte y>
		<#return x>
	<#else>
		<#return y>
	</#if>
</#function>
<#-- 最小值 -->
<#function min x y>
	<#if x lte y>
		<#return x>
	<#else>
		<#return y>
	</#if>
</#function>
<#macro dialog title="">
<div id='alert-modal' class='modal inmodal fade' tabindex='-1' role='dialog' aria-hidden='true'>
	<div class='modal-dialog'>
		<div class='modal-content animated fadeIn'>
			<div class='modal-header'>
				<button type='button' class='close' data-dismiss='modal'>
					<span aria-hidden='true'>&times;</span><span class='sr-only'>关闭</span>
				</button>
				<h4 id='alert-modal-title' class='modal-title'>${title}</h4>
			</div>
			<div id='alert-modal-body' class='modal-body'>
			<#nested />
			</div>
			<div class='modal-footer'>
				<button id='alert-cancel-btn' class='btn btn-white'
					data-dismiss='modal'>取消</button>
				<button id='alert-submit-btn' data-loading-text='保存中...'
					type='button' class='btn btn-primary'>保存</button>
			</div>
		</div>
	</div>
</div>
</#macro>
