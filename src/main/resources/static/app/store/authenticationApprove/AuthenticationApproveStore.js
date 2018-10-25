Ext.define('Admin.store.authenticationApprove.AuthenticationApproveStore', {
    extend: 'Ext.data.Store',
    storeId:'authenticationApproveStore',
    alias: 'store.authenticationApproveStore',
    model: 'Admin.model.authenticationApprove.AuthenticationApproveModel',
    /*data: {
		'content':[{
	       // "id": 1,
	        "userName": "user28",
	        "realName": "user28",
	        "idCardNumber": "28282828",
	        "idCardPicture": "1.png",
	        //"applyTime": "2018/10/22",
	        //"createTime": "2018/10/26",
	    },{
	        //"id": 2,
	        "userName": "user48",
	        "realName": "user48",
	        "idCardNumber": "48484848",
	        "idCardPicture": "2.png",
	        //"applyTime": "2018/10/23",
	        //"createTime": "2018/10/26",
    	}]
    },*/
    proxy: {
        type: 'ajax',
        url: '/authentication/approvelist', 			//需要修改
        reader : new Ext.data.JsonReader({  
            type : 'json',  
            rootProperty  : 'data.content',
            totalProperty : 'data.totalElements'
        })
        ,simpleSortMode: true
    },
   autoLoad: true,
    autoSync: true,
   // pageSize: 20,
    remoteSort: true
    /*sorters: {
        direction: 'DESC',
        property: 'id'
    }*/
});	