Ext.define('Admin.view.position.Position', {
    extend: 'Ext.container.Container',
    xtype: 'position',
    //requires: [],
    //controller: 'order',				//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    //viewModel: {type: 'orderlist'},	//viewModel：配置Stote数据源。多个视图共享Store。
    
    controller: 'positionViewController',
    viewModel: {type: 'positionViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'positionPanel'}]
});
