Ext.define('Admin.store.employeePositionInfoapprove.EmployeePositionInfoApproveStore', {
      extend: 'Ext.data.Store',
      storeId:'employeePositionInfoApproveStore',
      alias: 'store.employeePositionInfoApproveStore',
      model:'Admin.model.employeePositionInfoapprove.EmployeePositionInfoApproveModel',

    proxy: {
        type: 'ajax',
        url: '/employeePositionInfo/approve',	//mvc url  xxx.json
	  reader: new Ext.data.JsonReader({
	    	type:'json',
	    	rootProperty:'data.content',
	    	totalProperty: 'data.totalElements'
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
