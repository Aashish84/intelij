package com.example.onetomany_demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "device")
public class Device {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "alarm")
    private Integer alarm;

    @Column(name = "asset_match_status")
    private Integer assetMatchStatus;

    @Column(name = "bacnet_count")
    private Integer bacnetCount;

    @Column(name = "bacnet_status")
    private String bacnetStatus;

    @Column(name = "checklist_template_count")
    private Integer checklistTemplateCount;

    @Column(name = "connection_type")
    private String connectionType;

    @Column(name = "custom_fields")
    private null customFields;

    @Column(name = "description")
    private String description;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "disruptive_count")
    private Integer disruptiveCount;

    @Column(name = "disruptive_status")
    private String disruptiveStatus;

    @Column(name = "document_count")
    private Integer documentCount;

    @Column(name = "email_alert")
    private Integer emailAlert;

    @Column(name = "interface_count")
    private Integer interfaceCount;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "knx_count")
    private Integer knxCount;

    @Column(name = "knx_status")
    private String knxStatus;

    @Column(name = "last_seen_on")
    private BigDecimal lastSeenOn;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "local_vendor_email_alert")
    private Integer localVendorEmailAlert;

    @Column(name = "local_vendor_sms_alert")
    private Integer localVendorSmsAlert;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "lorawan_count")
    private Integer lorawanCount;

    @Column(name = "lorawan_status")
    private String lorawanStatus;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "matched_product_ids")
    private String matchedProductIds;

    @Column(name = "measuring_instrument_count")
    private Integer measuringInstrumentCount;

    @Column(name = "media_count")
    private Integer mediaCount;

    @Column(name = "model")
    private String model;

    @Column(name = "monitor")
    private Integer monitor;

    @Column(name = "monnit_count")
    private Integer monnitCount;

    @Column(name = "monnit_status")
    private String monnitStatus;

    @Column(name = "my_devices_count")
    private Integer myDevicesCount;

    @Column(name = "my_devices_status")
    private String myDevicesStatus;

    @Column(name = "network_layer")
    private String networkLayer;

    @Column(name = "notes_count")
    private Integer notesCount;

    @Column(name = "parent")
    private String parent;

    @Column(name = "pelican_count")
    private Integer pelicanCount;

    @Column(name = "pelican_status")
    private String pelicanStatus;

    @Column(name = "popup_notification")
    private Integer popupNotification;

    @Column(name = "position")
    private String position;

    @Column(name = "quick_link_name")
    private String quickLinkName;

    @Column(name = "quick_link_url")
    private String quickLinkUrl;

    @Column(name = "remote_access")
    private Integer remoteAccess;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "sms_alert")
    private Integer smsAlert;

    @Column(name = "snmp_count")
    private Integer snmpCount;

    @Column(name = "snmp_object_count")
    private Integer snmpObjectCount;

    @Column(name = "snmp_object_status")
    private String snmpObjectStatus;

    @Column(name = "snmp_parent")
    private String snmpParent;

    @Column(name = "snmp_parent_index")
    private String snmpParentIndex;

    @Column(name = "snmp_status")
    private String snmpStatus;

    @Column(name = "status")
    private Integer status;

    @Column(name = "subsystem_count")
    private Integer subsystemCount;

    @Column(name = "subsystem_parent_id")
    private String subsystemParentId;

    @Column(name = "ticket_count")
    private Integer ticketCount;

    @Column(name = "ticket_status")
    private String ticketStatus;

    @Column(name = "type")
    private String type;

    @Column(name = "user_connection_type")
    private String userConnectionType;

    @Column(name = "user_data_model")
    private String userDataModel;

    @Column(name = "user_data_name")
    private String userDataName;

    @Column(name = "user_data_type")
    private String userDataType;

    @Column(name = "user_data_vendor")
    private String userDataVendor;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "virtual_device_type")
    private Integer virtualDeviceType;

    @Column(name = "warranty")
    private String warranty;

    @Column(name = "docker_name")
    private String dockerName;

    @Column(name = "docker_vdms_id")
    private String dockerVdmsId;

    @Column(name = "global_vendor_id")
    private String globalVendorId;

    @Column(name = "local_vendor_id")
    private String localVendorId;

    @Column(name = "location_id")
    private String locationId;

    @Column(name = "other_vendor_1_id")
    private String otherVendor1Id;

    @Column(name = "other_vendor_2_id")
    private String otherVendor2Id;

    @Column(name = "other_vendor_3_id")
    private String otherVendor3Id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "measuring_instrument_status")
    private String measuringInstrumentStatus;

    @Column(name = "record_checklist_count")
    private Integer recordChecklistCount;

    @Column(name = "record_checklist_status")
    private String recordChecklistStatus;

    @Column(name = "daintree_count")
    private Integer daintreeCount;

    @Column(name = "daintree_status")
    private String daintreeStatus;

    @Column(name = "qrcode_count")
    private Integer qrcodeCount;

    @Column(name = "asset_image_url")
    private String assetImageUrl;

    @Column(name = "created_timestamp")
    private BigDecimal createdTimestamp;

    @Column(name = "ecobee_count")
    private Integer ecobeeCount;

    @Column(name = "ecobee_status")
    private String ecobeeStatus;

    @OneToMany
    @JoinColumn(name = "deviceId")
    private List<Connection> connections;
}
