Ext.define('Admin.store.expenseaccount.ExpenseAccountStore', {
    extend: 'Ext.data.Store',
    storeId:'expenseAccountStore',
    alias: 'store.expenseAccountStore',
    model: 'Admin.model.expenseaccount.ExpenseAccountModel',
    proxy: {
        type: 'rest',
        url: '/expenseaccount', 			//需要修改
        reader:{
	    	type:'json',
	    	rootProperty:'data.content',
	    	totalProperty: 'data.totalElements'
	    },
	    	writer: {
			type: 'json'
		},
	    	simpleSortMode: true
    },
    autoSync: true,
    pageSize:15,
    remoteSort: true,
    sorters: [
    	{ property: 'id',
    	  direction: 'desc'}],
    autoLoad: true
});	