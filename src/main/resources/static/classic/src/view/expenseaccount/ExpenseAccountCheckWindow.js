Ext.define('Admin.view.expenseaccount.ExpenseAccountCheckWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.expenseAccountCheckWindow',

	autoShow:true,
    height: 500,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '审核报销信息',
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
        ariaLabel: 'Check ExpenseAccount Information',
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
            name:'userName',
            readOnly: true
        },{ 
        	xtype: 'datefield',
            fieldLabel: '报销日期',
            name:'time',
            format: 'Y/m/d H:i:s',
            readOnly: true
         },{ 
        	xtype: 'textfield',
            fieldLabel: '报销金额',
            name:'amount'
         },{
            xtype: 'textfield',
            fieldLabel: '报销原因',
            name:'reason',
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '报销内容',
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
        handler: 'checkExpenseAccount'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }],

});
