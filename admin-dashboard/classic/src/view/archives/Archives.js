Ext.define('Admin.view.archives.Archives', {
    extend: 'Ext.container.Container',
    xtype: 'archives',
    //requires: [],
    //controller: 'order',				//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    //viewModel: {type: 'orderlist'},	//viewModel：配置Stote数据源。多个视图共享Store。
    
    controller: 'archivesViewController',
    viewModel: {type: 'archivesViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'archivesPanel'}]
});
