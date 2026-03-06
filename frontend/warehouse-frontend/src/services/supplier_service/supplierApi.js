import api from "@/lib/axios";

// ── Suppliers ─────────────────────────────────────────
const SUPPLIERS = "/api/v1/suppliers";

export const getAllSuppliers = (status) => api.get(SUPPLIERS, { params: status ? { status } : {} });
export const getSupplierById = (id) => api.get(`${SUPPLIERS}/${id}`);
export const createSupplier = (data) => api.post(SUPPLIERS, data);
export const updateSupplier = (id, data) => api.put(`${SUPPLIERS}/${id}`, data);
export const updateSupplierStatus = (id, data) => api.patch(`${SUPPLIERS}/${id}/status`, data);

// ── Purchase Orders ───────────────────────────────────
const PURCHASE_ORDERS = "/api/v1/purchase-orders";

export const getAllPurchaseOrders = (status, supplierId) => api.get(PURCHASE_ORDERS, { params: { ...(status && { status }), ...(supplierId && { supplierId }) } });
export const getPurchaseOrderById = (id) => api.get(`${PURCHASE_ORDERS}/${id}`);
export const createPurchaseOrder = (data) => api.post(PURCHASE_ORDERS, data);
export const submitPurchaseOrder = (id) => api.post(`${PURCHASE_ORDERS}/${id}/submit`);
export const approvePurchaseOrder = (id) => api.post(`${PURCHASE_ORDERS}/${id}/approve`);
export const sendPurchaseOrder = (id) => api.post(`${PURCHASE_ORDERS}/${id}/send`);
export const cancelPurchaseOrder = (id) => api.post(`${PURCHASE_ORDERS}/${id}/cancel`);
export const receiveGoodsAgainstPO = (poNumber, data) => api.post(`${PURCHASE_ORDERS}/receive-update/${poNumber}`, data);
