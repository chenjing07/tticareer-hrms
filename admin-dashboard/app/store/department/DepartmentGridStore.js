Ext.define('Admin.store.department.DepartmentGridStore', {
      extend: 'Ext.data.Store',
      storeId:'departmentGridStore',
      alias: 'store.departmentGridStore',
      model:'Admin.model.department.DepartmentModel',

    proxy: {
        type: 'rest',
        url: '/department',	//mvc url  xxx.json
	  reader:{
	    	type:'json',
	    	rootProperty:'data',
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
