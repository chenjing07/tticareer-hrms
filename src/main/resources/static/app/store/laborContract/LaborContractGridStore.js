Ext.define('Admin.store.laborContract.LaborContractGridStore', {
      extend: 'Ext.data.Store',
      storeId:'laborContractGridStore',
      alias: 'store.laborContractGridStore',
      model:'Admin.model.laborContract.LaborContractModel',

    proxy: {
        type: 'rest',
        url: '/laborContract',	//mvc url  xxx.json
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
