Ext.define('Admin.store.employeeapprove.EmployeeApproveStore', {
      extend: 'Ext.data.Store',
      storeId:'employeeApproveStore',
      alias: 'store.employeeApproveStore',
      model:'Admin.model.employeeapprove.EmployeeApproveModel',

    proxy: {
        type: 'ajax',
        url: '/employee/approve',	//mvc url  xxx.json
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
