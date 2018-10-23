Ext.define('Admin.store.writtenExamination.WrittenExaminationStore', {
      extend: 'Ext.data.Store',
      storeId:'writtenExaminationStore',
      alias: 'store.writtenExaminationStore',
      model:'Admin.model.writtenExamination.WrittenExaminationModel',

    proxy: {
        type: 'rest',
        url: '/writtenexamination',	//mvc url  xxx.json
	  reader:{
	    	type:'json',
	    	rootProperty:'data.content',
	    	totalProperty: 'data.totalElements'
	    },
	    	writer: {
			type: 'json'
		},
	    	simpleSortMode: true
    },
    autoLoad: true,
    autoSync: true,
    pageSize: 20,
    remoteSort: true,
    sorters: {
        direction: 'DESC',
        property: 'id'
    }
});
