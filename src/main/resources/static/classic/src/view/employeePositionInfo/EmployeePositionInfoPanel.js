Ext.define('Admin.view.employeePositionInfo.EmployeePositionInfoPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'employeePositionInfoPanel',

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
            title: '人员调动管理',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{employeePositionInfoLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
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
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'positionId',text: '岗位Id',
				renderer: function(val) {
				   var result;
		           Ext.Ajax.request({
					   url:'/position/getPositionNameById', 
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
		   {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'arrivePost',text: '到岗时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		   {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'leavePost',text: '离岗时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
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
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'transferReason',text: '调岗原因',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'leaveOpinion',text: '调出部门意见',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'arriveOpinion',text: '调入部门意见',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'state',text: ' 状态',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'note',text: ' 备注',hidden:true},
		   {xtype: 'datecolumn',cls:'content-column',dataIndex: 'createTime',text: '创建时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
                {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban',handler: 'onDisableButton'}
                    ]
                }
            ],
            tbar: [{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
						    fields: ["name", "value"],
						    data: [
						      	{ name: '员工工号', value: 'userName' },
								{ name: '创建时间', value: 'createTime' }
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
	           			 value:'userName',
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
							name:'employeePositionInfoPanelSearchField'
		                } ,'-', {
		                     xtype:'datefield',            
            			  reference:'searchDateFieldValue1',
            		 	  hidden :true,
            			  name:'employeePositionInfoPanelSearchDateField1',
            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                     xtype:'datefield',            
            			  reference:'searchDateFieldValue2',
            		 	  hidden :true,
            			  name:'employeePositionInfoPanelSearchDateField2',
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
				        itemId:'employeePositionInfoGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{employeePositionInfoLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#employeePositionInfoGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
