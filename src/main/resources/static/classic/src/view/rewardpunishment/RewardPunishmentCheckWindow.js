Ext.define('Admin.view.rewardpunishment.RewardPunishmentCheckWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.rewardPunishmentCheckWindow',

	autoShow:true,
    height: 500,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '奖惩信息审核',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    layout: {  
        type: 'hbox',  
        align: 'center',  
        pack: 'center'  
    }, 
    items: [
    	{
		scrollable: true,
        xtype: 'form',
        layout: {type:'vbox',align:'stretch'},
        padding: '10px',
        ariaLabel: 'Edit RewardPunishment Information',
        items: [{
        	field:'10px',
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
        	field:'10px',
            xtype: 'textfield',
            fieldLabel: 'employeeId',
            name:'employeeId',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName',
            readOnly: true
        },
        { 
            xtype: 'combobox',
            fieldLabel: '奖惩类型',
            width:50,
            name:'rewardAndPunishment',
            readOnly: true,
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '奖', value: '1' },
				{ name: '惩', value: '0' },
		    ]}),
		    		 displayField: 'name',
		             valueField:'value',
	           		 editable: false,
		             queryMode: 'local',
		             triggerAction: 'all',
		             emptyText: '请选择..',
         },
         {
            xtype: 'textfield',
            fieldLabel: '奖罚说明',
            name:'content',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note',
            readOnly: true
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: '审核',
        handler: 'checkRewardPunishment'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }],

});
