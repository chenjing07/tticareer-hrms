Ext.define('Admin.view.position.PositionPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'positionPanel',

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
            title: 'Position Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{positionLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'departmentId',text: '部门Id',
				renderer: function(val) {
				   var result;
		           Ext.Ajax.request({
					   url:'/department/getDepartmentNameById', 
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
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'positionNumber',text: '岗位编号'},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'positionName',text: '岗位名称',flex:1},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'superiorPositionid',text: '上级岗位Id',
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
			{xtype: 'gridcolumn',cls:'content-column',dataIndex: 'positionIntroduction',text: '岗位简介',hidden:true},
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
            tbar: [{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
						    fields: ["name", "value"],
						    data: [
						      	{ name: '岗位编号', value: 'positionNumber' },
								{ name: '岗位名称', value: 'positionName' }
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
							value:'positionNumber',
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
							name:'positionPanelSearchField'
		                } ,'-', {
		                     xtype:'datefield',            
            			  reference:'searchFieldValue1',
            		 	  hidden :true,
            			  name:'positionPanelSearchField1'		                
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
				        itemId:'positionGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{positionLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#positionGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
