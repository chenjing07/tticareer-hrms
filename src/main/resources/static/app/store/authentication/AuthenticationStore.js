Ext.define('Admin.store.authentication.AuthenticationStore', {
    extend: 'Ext.data.Store',
    storeId:'authenticationStore',
    alias: 'store.authenticationStore',
    model: 'Admin.model.authentication.AuthenticationModel',
   
    proxy: {
        type: 'ajax',
        url: '/authentication', 			//需要修改
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