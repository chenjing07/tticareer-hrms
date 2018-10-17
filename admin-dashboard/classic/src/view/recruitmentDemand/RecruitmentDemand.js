﻿Ext.define('Admin.view.recruitmentDemand.RecruitmentDemand', {
    extend: 'Ext.container.Container',
    xtype: 'recruitmentDemand',
    //requires: [],
    //controller: 'order',				//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    //viewModel: {type: 'orderlist'},	//viewModel：配置Stote数据源。多个视图共享Store。
    
    controller: 'recruitmentDemandViewController',
    viewModel: {type: 'recruitmentDemandViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'recruitmentDemandPanel'}]
});