Ext.define('Admin.store.employee.EmployeePositionInfoGridStore', {
      extend: 'Ext.data.Store',
      storeId:'employeePositionInfoGridStore',
      alias: 'store.employeePositionInfoGridStore',
      model:'Admin.model.employeePositionInfo.EmployeePositionInfoModel',

    proxy: {
        type: 'rest',
        url: '/employeePositionInfo',	//mvc url  xxx.json
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
    autoLoad: 'true',
    autoSync: true,
    pageSize: 20,
    remoteSort: true,
    sorters: {
        direction: 'DESC',
        property: 'id'
    }
});
