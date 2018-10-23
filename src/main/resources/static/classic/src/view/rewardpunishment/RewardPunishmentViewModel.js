Ext.define('Admin.view.rewardpunishment.RewardPunishmentViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.rewardPunishmentViewModel',

    requires: [
        'Ext.data.Store',
        'Ext.data.proxy.Memory',
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.field.Date',
        'Ext.data.field.Boolean',
        'Ext.data.reader.Json'
    ],

    stores: {
    	rewardPunishmentLists: {type: 'rewardPunishmentStore'}
    }
});
