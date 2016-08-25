<#--
	分页模板
		@param hrefSubfix 自定义链接后缀（option）
	用例: 
	<@pagination content=page hrefSubfix="state='NORMAL&searchText='test''"/>
   -->
<#macro pagination size=10 content=[] hrefSubfix="">
<#assign current=content.number+1 />
<#assign begin=max(current - size/2, 1) />
<#assign end=min((begin + (size - 1)), content.getTotalPages()) />
<#assign end=max(end, begin) />
<div class="dataTables_paginate paging_simple_numbers" id="editable_paginate">
<span style='display:inline-block; vertical-align: text-bottom; height: 36px; line-height: 36px;'>共${content.getTotalElements()}条</span>
<ul class="pagination">
	<#if content.hasPrevious()>
	<li class="paginate_button previous" aria-controls="editable" tabindex="0">
		<a href="?pageNumber=1&${hrefSubfix!}">‹‹</a>
	</li>
	<li class="paginate_button previous" aria-controls="editable" tabindex="0">
		<a href="?pageNumber=${current-1}&${hrefSubfix}">‹</a>
	</li>
	<#else>
	<li class="paginate_button previous disabled" aria-controls="editable" tabindex="0"><a href="javascript:void(0)">‹‹</a></li>
	<li class="paginate_button previous disabled" aria-controls="editable" tabindex="0"><a href="javascript:void(0)">‹</a></li>
	</#if>
	<#list begin..end as i>
		<#if i == current>
			<li class="paginate_button active" aria-controls="editable" tabindex="0"><a href="javascript:void(0)">${i}</a></li>
		<#else>
    		<li class="paginate_button" aria-controls="editable" tabindex="0">
    			<a href="?pageNumber=${i}&${hrefSubfix!}">${i}</a>
    		</li>
		</#if>
	</#list>
	<#if content.hasNext()>
		<li class="paginate_button next" aria-controls="editable" tabindex="0" id="editable_next">
			<a href="${current+1}&${hrefSubfix!}">›</a>
		</li>
		<li class="paginate_button next" aria-controls="editable" tabindex="0" id="editable_next">
			<a href="${content.getTotalPages()}&${hrefSubfix!}">››</a>
		</li>
	<#else>
		<li class="paginate_button next disabled" aria-controls="editable" tabindex="0" id="editable_next"><a href="javascript:void(0)">›</a></li>
		<li class="paginate_button next disabled" aria-controls="editable" tabindex="0" id="editable_next"><a href="javascript:void(0)">››</a></li>
	</#if>
</ul>
</div>
</#macro>

