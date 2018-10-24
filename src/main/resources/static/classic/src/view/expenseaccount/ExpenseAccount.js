Ext.define('Admin.view.expenseaccount.ExpenseAccount', {
    extend: 'Ext.container.Container',
    xtype: 'expenseAccount',
    //requires: [],
    controller: 'expenseAccountViewController',//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    viewModel: {type: 'expenseAccountViewModel'},//viewModel：配置Store数据源。多个视图共享Store。
    	
    layout: 'fit',
    items: [{xtype:'expenseAccountPanel'}]
});
