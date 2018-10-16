Ext.define('Admin.store.recruitmentDemand.RecruitmentDemandStore', {
      extend: 'Ext.data.Store',
      storeId:'recruitmentDemandStore',
      alias: 'store.recruitmentDemandStore',
      model:'Admin.model.recruitmentDemand.RecruitmentDemandModel',

    proxy: {
        type: 'rest',
        url: '/recruitmentDemand',	//mvc url  xxx.json
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
