package nguyen.storeserver.controller;

import nguyen.storeserver.dto.OrderDTO;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.PurchaseOrder;
import nguyen.storeserver.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private PurchaseOrderService orderService;
    @Autowired
    public OrderController(PurchaseOrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public List<PurchaseOrder> getAllOrder() {
        return orderService.getAllPurchaseOrders();
    }
    @GetMapping(value = "/id")
    public Optional<PurchaseOrder> findOrderById(@RequestParam Integer orderId) {
        return orderService.findPurchaseOrderById(orderId);
    }
    @GetMapping(value = "/costumer")
    public List<PurchaseOrder> findOrderByCostumer(@RequestParam String costumer){
        return orderService.findPurchaseOrderByUser(costumer);
    }
    @GetMapping(value = "/staff")
    public List<PurchaseOrder> findOrderByStaff(@RequestParam String staff){
        return orderService.findPurchaseOrderByStaff(staff);
    }
    @GetMapping(value = "/item")
    public List<PurchaseOrder> findOrderByItemId(@RequestParam Integer itemId){
        return orderService.findPurchaseOrderByItemId(itemId);
    }
    @GetMapping(value = "/store")
    public List<PurchaseOrder> findOrderByStore(@RequestParam String store){
        return orderService.findPurchaseOrderByStore(store);
    }
    @GetMapping(value = "/quantity")
    public PurchaseOrder findOrderByCreateTime(@RequestParam LocalDateTime dateTime){
        return orderService.findPurchaseOrderByCreateTime(dateTime);
    }
    @GetMapping(value = "/process")
    public List<PurchaseOrder> findOrderByProcess(@RequestParam String process){
        return orderService.findPurchaseOrderByProcess(process);
    }
    @PostMapping(value = "/add")
    public ResponseDTO addOrder(@RequestBody OrderDTO orderDTO) {
        ResponseDTO response = new ResponseDTO();
        response = orderService.AddOder(orderDTO);
        return response;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteItem(@PathVariable(name = "id") Integer orderId) {
        ResponseDTO response = new ResponseDTO();
        response = orderService.DeleteOrder(orderId);
        return response;
    }
}
