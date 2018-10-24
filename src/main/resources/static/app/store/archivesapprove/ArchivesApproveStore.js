Ext.define('Admin.store.archivesapprove.ArchivesApproveStore', {
      extend: 'Ext.data.Store',
      storeId:'archivesApproveStore',
      alias: 'store.archivesApproveStore',
      model:'Admin.model.archivesapprove.ArchivesApproveModel',

    proxy: {
        type: 'ajax',
        url: '/archives/approve',	//mvc url  xxx.json
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
