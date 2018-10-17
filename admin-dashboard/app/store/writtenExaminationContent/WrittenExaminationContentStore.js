Ext.define('Admin.store.writtenExaminationContent.WrittenExaminationContentStore', {
      extend: 'Ext.data.Store',
      storeId:'writtenExaminationContentStore',
      alias: 'store.writtenExaminationContentStore',
      model:'Admin.model.writtenExaminationContent.WrittenExaminationContentModel',

    proxy: {
        type: 'rest',
        url: '/writtenExaminationContent',	//mvc url  xxx.json
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
