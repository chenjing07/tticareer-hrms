Ext.define('Admin.store.salarydetail.SalaryDetailStore', {
    extend: 'Ext.data.Store',
    storeId:'salaryDetailStore',
    alias: 'store.salaryDetailStore',
    model: 'Admin.model.salarydetail.SalaryDetailModel',
    proxy: {
        type: 'rest',
        url: '/salarydetail', 			//需要修改
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