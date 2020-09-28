import { Pipe, PipeTransform } from '@angular/core';
import { ResourceEnquiry } from './models/resource-enquiry.model';
import { ResourceEnquiryService } from './services/resource-enquiry.service';

@Pipe({
  name: 'searchFilterResourceEnquiry'
})
export class SearchFilterResourceEnquiryPipe implements PipeTransform {
  
  transform(resourceEnquiry: ResourceEnquiry[],searchValue: string): ResourceEnquiry[] {
    if(!resourceEnquiry || !searchValue){
      return resourceEnquiry;
    }
    return resourceEnquiry.filter(resourceEnquiry => resourceEnquiry.resourcesId?.resourceName.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase())||resourceEnquiry.status?.statusValue.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase())||resourceEnquiry.customerId?.customerName.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()));
  }

}
