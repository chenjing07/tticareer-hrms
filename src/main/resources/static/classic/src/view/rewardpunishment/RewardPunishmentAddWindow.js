Ext.define('Admin.view.rewardpunishment.RewardPunishmentAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.rewardPunishmentAddWindow',

	autoShow:true,
    height: 500,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '奖惩信息添加',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    layout: {  
        type: 'hbox',  
        align: 'center',  
        pack: 'center'  
    }, 
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: {type:'vbox',align:'stretch'},
        padding: '10px',
        ariaLabel: 'Add RewardPunishment Information',
        items: [{
        	field:'10px',
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{ 
            xtype: 'combobox',
            fieldLabel: '奖惩类型',
            width:50,
            name:'rewardAndPunishment',
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
		             width: 50,
         },{
            xtype: 'textfield',
            fieldLabel: '奖罚说明',
            name:'content'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'addSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }],

});
