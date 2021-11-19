package nguyen.storeserver.controller;

import nguyen.storeserver.dto.ItemDTO;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.Item;
import nguyen.storeserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    private ItemService itemService;
    @Autowired
    public ItemController (ItemService itemService){
        this.itemService = itemService;
    }
    @GetMapping
    public List<Item> getAvailableItems() {
        return itemService.getAllItemsActive();
    }
    @GetMapping(value = "/allitem")
    public List<Item> getAllItems (){
        return itemService.getAllItems();
    }
    @GetMapping(value = "/itemdeleted")
    public List<Item> getUnAvailableItems(){
        return itemService.getAllItemsUnActive();
    }
    @GetMapping(value = "/id")
    public Optional<Item> findItemById(@RequestParam Integer itemId) {
        return itemService.findById(itemId);
    }
    @GetMapping(value = "/product")
    public List<Item> findItemByProduct(@RequestParam String product){
        return itemService.findByProductName(product);
    }
    @GetMapping(value = "/color")
    public List<Item> findItemByColor(@RequestParam String color){
        return itemService.findByColorName(color);
    }
    @GetMapping(value = "/size")
    public List<Item> findItemBySize(@RequestParam int size){
        return itemService.findBySize(size);
    }
    @GetMapping(value = "/quantity")
    public List<Item> findItemByQuantity(@RequestParam int quantity){
        return itemService.findByNumItems(quantity);
    }
    @GetMapping(value = "/type")
    public List<Item> findItemByType(@RequestParam String type){
        return itemService.findByType(type);
    }
    @GetMapping(value = "/store")
    public List<Item> findItemByStore(@RequestParam String store){
        return itemService.findByStore(store);
    }
    @GetMapping(value = "/sale")
    public List<Item> findItemBySale(@RequestParam int sale){
        return itemService.findBySale(sale);
    }
    @PostMapping(value = "/add")
    public ResponseDTO addItem(@RequestBody ItemDTO itemDTO) {
        ResponseDTO response = new ResponseDTO();
        response = itemService.AddItem(itemDTO);
        return response;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteItem(@PathVariable(name = "id") Integer itemId) {
        ResponseDTO response = new ResponseDTO();
        response = itemService.DeleteItem(itemId);
        return response;
    }
    @PutMapping(value = "/update")
    public ResponseDTO updateItem(@RequestBody ItemDTO itemDTO){
        ResponseDTO response = new ResponseDTO();
        response = itemService.UpdateItem(itemDTO);
        return response;
    }
}
