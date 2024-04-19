import { HttpInterceptorFn } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { SnackbarService } from '../service/snackbar.service';
import { inject } from '@angular/core';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  const snackBarService = inject(SnackbarService);
  return next(req).pipe(
    catchError((error: any) => {
      snackBarService.openSnackBar(error.error?.description);
      return throwError(() => error);
    })
  );
};
