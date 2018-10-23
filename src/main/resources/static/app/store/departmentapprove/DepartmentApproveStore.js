Ext.define('Admin.store.departmentapprove.DepartmentApproveStore', {
      extend: 'Ext.data.Store',
      storeId:'departmentApproveStore',
      alias: 'store.departmentApproveStore',
      model:'Admin.model.departmentapprove.DepartmentApproveModel',

    proxy: {
        type: 'ajax',
        url: '/department/approve',	//mvc url  xxx.json
	  reader: new Ext.data.JsonReader({
	    	type:'json',
	    	rootProperty:'data',
	    	totalProperty: 'totalElements'
	    }),
	    	
	    	simpleSortMode: true
    },
    autoLoad: 'true',
    
    remoteSort: true,
    sorters: {
        direction: 'DESC',
        property: 'id'
    }
});
