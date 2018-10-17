Ext.define('Admin.store.laborContractapprove.LaborContractApproveStore', {
      extend: 'Ext.data.Store',
      storeId:'laborContractApproveStore',
      alias: 'store.laborContractApproveStore',
      model:'Admin.model.laborContractapprove.LaborContractApproveModel',

    proxy: {
        type: 'ajax',
        url: '/laborContract/approve',	//mvc url  xxx.json
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
