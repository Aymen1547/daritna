import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/Product';
import { ProductsService } from 'src/app/services/products.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { User } from 'src/app/models/User';
import { CartItemsService } from 'src/app/services/cart-items.service';
import { UserService } from 'src/app/services/userServices/user.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
    public product : Product
    public user : User
    public isProductInCart : boolean

    constructor(
        private route : ActivatedRoute, 
        private productsService : ProductsService, 
        private usersService : UserService,
        private cartItemsService : CartItemsService
    ) { }

    ngOnInit(): void {
        this.productsService.getProduct(this.route.snapshot.paramMap.get('id')).subscribe((product : Product) => {
            this.product = product
           console.log(this.product);

            this.product.imageUrl = product.image ? 'data:image/jpeg;base64,' + product.image :
            "../../../assets/static/images/product-placeholder.png";
        }, (error: ErrorEvent) => {
            console.log(this.product);
        })

            this.user = this.usersService.getUserFromLocalCache();
            console.log(this.product);
            this.getCartItem()
      
    }

    addToCart () {
        this.cartItemsService.addToUserCart(this.user.userId, this.product.id.toString()).subscribe(res => {
            this.getCartItem()
        })
    }

    getCartItem () {
        console.log(this.user.userId);
        console.log(this.product);
        this.cartItemsService.getCartItem(this.user.userId, this.product.id).subscribe(res => {
            this.isProductInCart = true
        }, (error : ErrorEvent) => {
            this.isProductInCart = false
        })

    }
}