Ext.define('Admin.view.laborContract.LaborContractPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'laborContractPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.grid.column.RowNumberer',
        'Ext.grid.column.Date'
    ],
    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '合同管理',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{laborContractLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'employerName',text: '甲方名称',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'employeeId',text: '员工Id',
				renderer: function(val) {
				   var result;
		           Ext.Ajax.request({
					   url:'/employee/getEmployeeNameById', 
					   method:'get', 
					   params:{id:val}, 
					   async: false,
					   success:function(response, options) {
          					var json = Ext.util.JSON.decode(response.responseText);
          					if (json.data) {
            					result = json.data;
								//console.log(result);
         				 	}
						}
					});
					return result;
			    }
			},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'contractTimeLimit',text: '合同期限'},
		   {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'contractStart',text: '开始时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'checkStatus',text: '审查状态' ,
				renderer: function(val) {
		            if (val =='1') {
			            return '<span style="color:green;">已通过审查</span>';
			        } else if (val =='0') {
			            return '<span style="color:blue;">待审查</span>';
			        } else{
			            return '<span style="color:red;">未通过审查</span>';
			        }
			        return val;}
			},
		   {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'contractEnd',text: '终止时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'workContent',text: '工作内容',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'workPlace',text: '工作地点',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'laborProtection',text: '劳动保护',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'laborReward',text: '劳动报酬',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'laborConditions',text: '劳动条件',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'defaultResponsibility',text: '违约责任',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'socialInsurance',text: '社会保险',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'contractChange',text: '合同变更',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'state',text: ' 状态',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'note',text: ' 备注',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'createTime',text: '创建时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
           
			
			{xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
				items: [
					{xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
					{xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
					{xtype: 'button',iconCls: 'x-fa fa-ban',handler: 'onDisableButton'}
				]
			}
            ],
		tbar: [		{ 
						xtype: 'combobox',
						reference:'searchFieldName',
						hideLabel: true, 
						store:Ext.create("Ext.data.Store", {
						fields: ["name", "value"],
							data: [
								{ name: '甲方', value: 'employerName' },
								{ name: '员工工号', value: 'userName' },
								{ name: '合同创建时间', value: 'createTime' }
							]
						}),     
						displayField: 'name',
						valueField:'value',
						value:'employerName',
						editable: false,
						queryMode: 'local',
						triggerAction: 'all',
						emptyText: 'Select a state...',
						width: 135,
						listeners:{
							select: 'searchComboboxSelectChuang'
						}
					},'-', {
						xtype:'textfield',
						reference:'searchFieldValue',
						name:'laborContractPanelSearchField'
					} ,'-', {
						xtype:'textfield',
						reference:'searchFieldValue1',
						hidden :true,
						name:'laborContractPanelSearchField1'
					} ,'-',{
						xtype:'datefield',            
						reference:'searchDateFieldValue1',
						hidden :true,
						name:'laborContractPanelSearchDateField1',
						format: 'Y/m/d H:i:s'
					},'-', {
						xtype:'datefield',            
						reference:'searchDateFieldValue2',
						hidden :true,
						name:'laborContractPanelSearchDateField2',
						format: 'Y/m/d H:i:s'
					},'-',{
					text: 'Search',
					iconCls: 'fa fa-search',
					handler: 'quickSearch'
				    },'-',{
				        text: 'Search More',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'laborContractGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{laborContractLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#laborContractGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});

