Ext.define('Admin.store.rewardpunishment.RewardPunishmentStore', {
    extend: 'Ext.data.Store',
    storeId:'rewardPunishmentStore',
    alias: 'store.rewardPunishmentStore',
    model: 'Admin.model.rewardpunishment.RewardPunishmentModel',
    proxy: {
        type: 'rest',
        url: '/rewardpunishment', 			//需要修改
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
    autoSync: true,
    pageSize:15,
    remoteSort: true,
    sorters: [
    	{ property: 'id',
    	  direction: 'desc'}],
    autoLoad: true
});	