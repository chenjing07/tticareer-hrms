Ext.define('Admin.store.archives.ArchivesGridStore', {
      extend: 'Ext.data.Store',
      storeId:'archivesGridStore',
      alias: 'store.archivesGridStore',
      model:'Admin.model.archives.ArchivesModel',

    proxy: {
        type: 'rest',
        url: '/archives',	//mvc url  xxx.json
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
