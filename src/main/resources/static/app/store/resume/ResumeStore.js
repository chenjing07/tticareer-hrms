Ext.define('Admin.store.resume.ResumeStore', {
      extend: 'Ext.data.Store',
      storeId:'resumeStore',
      alias: 'store.resumeStore',
      model:'Admin.model.resume.ResumeModel',

    proxy: {
        type: 'rest',
        url: '/resume',	//mvc url  xxx.json
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
