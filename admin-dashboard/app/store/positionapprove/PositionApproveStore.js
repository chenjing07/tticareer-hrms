Ext.define('Admin.store.positionapprove.PositionApproveStore', {
      extend: 'Ext.data.Store',
      storeId:'positionApproveStore',
      alias: 'store.positionApproveStore',
      model:'Admin.model.positionapprove.PositionApproveModel',

    proxy: {
        type: 'ajax',
        url: '/position/approve',	//mvc url  xxx.json
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
