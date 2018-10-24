
Ext.define('Admin.view.laborContract.LaborContractSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.laborContractSearchWindow',

    y:10,
    height: 280,
   // minHeight: 100,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: '搜索合同',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Search LaborContract Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '甲方',
            name:'employerName'
        }, {
            xtype: 'textfield',
            fieldLabel: '员工工号',
            name:'userName'
        }, {
            xtype: 'datefield',
            fieldLabel: 'From',
            name:'createTimeStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'To',
            name:'createTimeEnd',
            format: 'Y/m/d H:i:s'
        }
	]
    }],
    buttons:  ['-\x3e',{
        xtype: 'button',
        text: 'Submit',
        handler: 'searchSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    },'-\x3e']
});
