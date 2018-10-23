Ext.define('Admin.store.interview.InterviewStore', {
      extend: 'Ext.data.Store',
      storeId:'interviewStore',
      alias: 'store.interviewStore',
      model:'Admin.model.interview.InterviewModel',

    proxy: {
        type: 'rest',
        url: '/interview',	//mvc url  xxx.json
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
