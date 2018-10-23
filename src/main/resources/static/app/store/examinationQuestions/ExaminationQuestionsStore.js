Ext.define('Admin.store.examinationQuestions.ExaminationQuestionsStore', {
      extend: 'Ext.data.Store',
      storeId:'examinationQuestionsStore',
      alias: 'store.examinationQuestionsStore',
      model:'Admin.model.examinationQuestions.ExaminationQuestionsModel',

    proxy: {
        type: 'rest',
        url: '/examinationquestions',	//mvc url  xxx.json
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
    autoLoad:true,
    autoSync: true,
    pageSize: 20,
    remoteSort: true,
    sorters: {
        direction: 'DESC',
        property: 'id'
    }
});
