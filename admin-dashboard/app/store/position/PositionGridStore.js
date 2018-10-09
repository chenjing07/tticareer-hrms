Ext.define('Admin.store.position.PositionGridStore', {
      extend: 'Ext.data.Store',
      storeId:'positionGridStore',
      alias: 'store.positionGridStore',
      model:'Admin.model.position.PositionModel',

    proxy: {
        type: 'rest',
        url: '/position',	//mvc url  xxx.json
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
