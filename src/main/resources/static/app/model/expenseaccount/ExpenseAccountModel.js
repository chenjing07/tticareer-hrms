Ext.define('Admin.model.expenseaccount.ExpenseAccountModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
    	{type: 'int',name: 'id'},
    	{type:'string',name:'userName'},
    	{type: 'float', name: 'amount'},
    	{type: 'string', name: 'reason'},
    	{type: 'string', name: 'content'},
		{type: 'date',name: 'time',dateFormat:'Y/m/d H:i:s'},
    	{type: 'string',name: 'note'}
    ],
    	proxy: {
		type: 'rest',
		url: '/expenseaccount/save'
	}
});