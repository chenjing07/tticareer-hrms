Ext.define('Admin.store.employee.EmployeeGridStore', {
      extend: 'Ext.data.Store',
      storeId:'employeeGridStore',
      alias: 'store.employeeGridStore',
      model:'Admin.model.employee.EmployeeModel',

    proxy: {
        type: 'rest',
        url: '/employee',	//mvc url  xxx.json
	  reader:{
	    	type:'json',
	    	rootProperty:'content',
	    	totalProperty: 'totalElements'
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
