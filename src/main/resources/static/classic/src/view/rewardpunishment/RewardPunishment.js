Ext.define('Admin.view.rewardpunishment.RewardPunishment', {
    extend: 'Ext.container.Container',
    xtype: 'rewardPunishment',
    //requires: [],
    controller: 'rewardPunishmentViewController',//viewController:代码与视图分离。声明视图绑定的事件，可以多个视图共享。
    viewModel: {type: 'rewardPunishmentViewModel'},//viewModel：配置Store数据源。多个视图共享Store。
    	
    layout: 'fit',
    items: [{xtype:'rewardPunishmentPanel'}]
});
