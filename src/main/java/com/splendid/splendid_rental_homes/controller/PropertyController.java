package com.splendid.splendid_rental_homes.controller;
import com.splendid.splendid_rental_homes.model.User;
import com.splendid.splendid_rental_homes.repository.UserRepository;
import com.splendid.splendid_rental_homes.model.Property;
import com.splendid.splendid_rental_homes.repository.PropertyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    public PropertyController(PropertyRepository propertyRepository, UserRepository userRepository) {
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable int id) {
        return propertyRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Property addProperty(@RequestBody Property property) {
        User landlord = userRepository.findById(property.getLandlord().getId()).orElse(null);
        if (landlord == null) {
            return null;
        }
        property.setLandlord(landlord);
        return propertyRepository.save(property);
    }

    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable int id, @RequestBody Property updatedProperty) {
        Property existingProperty = propertyRepository.findById(id).orElse(null);
        if (existingProperty == null) {
            return null;
        }

        existingProperty.setAddress(updatedProperty.getAddress());
        existingProperty.setCity(updatedProperty.getCity());
        existingProperty.setState(updatedProperty.getState());
        existingProperty.setZipCode(updatedProperty.getZipCode());
        existingProperty.setRent(updatedProperty.getRent());
        existingProperty.setBedrooms(updatedProperty.getBedrooms());
        existingProperty.setBathrooms(updatedProperty.getBathrooms());
        existingProperty.setDescription(updatedProperty.getDescription());
        existingProperty.setAvailable(updatedProperty.isAvailable());

        User landlord = userRepository.findById(updatedProperty.getLandlord().getId()).orElse(null);
        if (landlord == null) {
            return null;
        }

        existingProperty.setLandlord(landlord);
        return propertyRepository.save(existingProperty);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable int id) {
        propertyRepository.deleteById(id);
    }
}
